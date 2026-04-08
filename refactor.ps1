$branches = @(
    "UC1-Initialize-Train-and-Display-Consist-Summary",
    "UC2-Add-Passenger-Bogies-to-Train",
    "UC3-Track-Unique-Bogie-IDs",
    "UC4-Maintain-Ordered-Bogie-IDs",
    "UC5-Preserve-Insertion-Order-of-Bogies",
    "UC6-Map-Bogie-to-Capacity",
    "UC7-Sort-Bogies-by-Capacity",
    "UC8-Filter-Passenger-Bogies-Using-Streams",
    "UC9-Group-Bogies-by-Type",
    "UC10-Count-Total-Seats-in-Train",
    "UC11-Validate-Train-ID-and-Cargo-Codes",
    "UC12-Safety-Compliance-Check-for-Goods-Bogies"
)

git config --global user.email "bot@example.com"
git config --global user.name "Assistant"

# Fix dev branch
git checkout -B dev origin/main
New-Item -ItemType Directory -Force -Path App\src
Copy-Item -Path dev\* -Destination App\src -Recurse
Get-ChildItem -Path App\src\*.java | ForEach-Object {
    $content = Get-Content $_.FullName
    $content -replace '^package dev;', '' | Set-Content $_.FullName
}
Get-ChildItem -Path . -Directory | Where-Object { $_.Name -match '^UC\d+$' -or $_.Name -eq 'dev' } | Remove-Item -Recurse -Force
git add .
git commit -m "Add code for branch dev"
git push origin dev -f

# Fix UC branches
for ($i=0; $i -lt $branches.Length; $i++) {
    $branch = $branches[$i]
    $ucFolder = "UC$($i+1)"
    
    git checkout -B $branch origin/main
    New-Item -ItemType Directory -Force -Path App\src
    Copy-Item -Path "$ucFolder\*" -Destination App\src -Recurse
    Get-ChildItem -Path App\src\*.java | ForEach-Object {
        $content = Get-Content $_.FullName
        $content -replace '^package UC\d+;', '' | Set-Content $_.FullName
    }
    Get-ChildItem -Path . -Directory | Where-Object { $_.Name -match '^UC\d+$' -or $_.Name -eq 'dev' } | Remove-Item -Recurse -Force
    git add .
    git commit -m "Add code for branch $branch"
    git push origin $branch -f
}

# Fix main branch
git checkout -B main origin/main
Get-ChildItem -Path . -Directory | Where-Object { $_.Name -match '^UC\d+$' -or $_.Name -eq 'dev' -or $_.Name -eq 'App' } | Remove-Item -Recurse -Force
git add .
git commit -m "Clean main branch"
git push origin main -f

# Clean up local workspace slightly to remain on dev branch for ease
git checkout dev
