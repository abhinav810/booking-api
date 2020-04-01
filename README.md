# Booking-API

API Designed for Hotel Booking from Website.

> There are 3 endpoints exposed:
```
/bookings - GET
/bookings - POST
/bookings/{id} - GET
```

The form body for POST method should be in the form of:
```
{
  user: #,
  room: #
}
```
which mentions userId and roomId for booking.

According to the price of room, user bonus points will be deducted and the room status will change from OPEN to BOOKED or PENDING APPROVAL.
If the room is booked it will show the status as CANNOT BE BOOKED.
