git config --global user.email "bot@example.com"
git config --global user.name "Assistant"

git add .
git commit -m "Initialize Train Consist Management App (UC1-UC12)"
git branch -M main
git push -u origin main -f

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

foreach ($branch in $branches) {
    git checkout -b $branch
    git push -u origin $branch -f
}

git checkout main
