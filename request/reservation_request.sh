curl --location --request POST 'http://localhost:8080/reservations' \
--header 'Content-Type: application/json' \
--data-raw '{
    "seanceId": 2,
    "seats": [
        {
            "seatRow": 1,
            "seat": 1
        }
    ],
    "firstName": "Mateusz",
    "secondName": "Kowalski",
    "ticketType": "ADULT"
}'
$SHELL