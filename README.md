# Notes
Приложение с новостями. Используются: api https://newsapi.org/, dependency injection (dagger), MVVM, compose, clean architecture.

<img src="https://private-user-images.githubusercontent.com/62353645/331313556-39136ea0-d6de-4751-bcfc-a311b7060062.jpg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTU4Nzk2MDgsIm5iZiI6MTcxNTg3OTMwOCwicGF0aCI6Ii82MjM1MzY0NS8zMzEzMTM1NTYtMzkxMzZlYTAtZDZkZS00NzUxLWJjZmMtYTMxMWI3MDYwMDYyLmpwZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA1MTYlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNTE2VDE3MDgyOFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWIyYTJkMWFjZDM1OWEzZGU0NjE1NzI0ZTIyM2QwYmZiNDEwZThiMGJkOTdmNjU1NDliNmJjNzNjNjQ2YWQ1ZTcmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.RPU82t2RDQGu7d22fvECtfsT-OXpHjO8qDmToDHPmgA" width="500">
<img src="https://private-user-images.githubusercontent.com/62353645/331313564-fb4a6aa5-c584-4f71-ab65-9d1531510eda.jpg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTU4Nzk3NDQsIm5iZiI6MTcxNTg3OTQ0NCwicGF0aCI6Ii82MjM1MzY0NS8zMzEzMTM1NjQtZmI0YTZhYTUtYzU4NC00ZjcxLWFiNjUtOWQxNTMxNTEwZWRhLmpwZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA1MTYlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNTE2VDE3MTA0NFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTY0Y2JkOWUwZDc2NDVhNjhhNjA2NzJkN2FlNTZjNTYyN2ZjNjdhM2E4ZDI1MzEyNGZmOTgzMmJhMmUxYzMwY2QmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.9lOALVsANogyyBh8eAZEgYY63zfM2R_9wvOJA9naK7Y" width="500">
<img src="https://private-user-images.githubusercontent.com/62353645/331313565-7ed6d71b-83c6-4bdd-9cb5-a0f4e86597fb.jpg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTU4Nzk3NDQsIm5iZiI6MTcxNTg3OTQ0NCwicGF0aCI6Ii82MjM1MzY0NS8zMzEzMTM1NjUtN2VkNmQ3MWItODNjNi00YmRkLTljYjUtYTBmNGU4NjU5N2ZiLmpwZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA1MTYlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNTE2VDE3MTA0NFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWE0NjJlZDBjYmNmMDVlNjExN2FjOTVlOGQxNDQ1ZWVlZDViN2ZkOTAyNTI5MzU3OWM4MjI2NDBiM2E1MGYxY2QmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0._lgLHIwBw2GApKv-YaBCMwU33gE2T5VPj7ngVogImfQ" width="500">