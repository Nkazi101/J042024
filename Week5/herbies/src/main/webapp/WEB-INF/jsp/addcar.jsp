<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Car</title>
</head>
<body>

    <jsp:include page="navbar.jsp"/>

<h1>Add Car</h1>

    <form method="post" action="/addcar">

        <label>Manufacturer Name</label> <br>
        <input type="text" name="manufacturerName"/> <br>
        <label>Model</label> <br>
        <input type="text" name="model"/> <br>
        <label>Year</label> <br>
        <input type="number" name="year"/> <br>
        <label>Color</label> <br>
        <input type="text" name="color" /> <br>
        <label>Transmission</label> <br>
        <input type="text" name="transmission"/> <br>
        <label>Mileage</label> <br>
        <input type="number" name="mileage"/> <br>
        <label>Description</label> <br>
        <input type="text" name="description" /> <br>
        <label>Engine Type</label> <br>
        <input type="text" name="engineType"/> <br>
        <label>Body Style</label> <br>
        <select name="bodyStyle">
            <option value="SEDAN">SEDAN</option>
            <option value="HATCHBACK">HATCHBACK</option>
            <option value="SUV">SUV</option>
            <option value="CONVERTIBLE">CONVERTIBLE</option>
            <option value="COUPE">COUPE</option>
        </select> <br>
        <label>Price</label> <br>
        <input type="number" name="price"/> <br>
        <label>Is Available</label> <br>
        <input type="checkbox" name="isAvailable"/> <br>
        <label>Is New</label> <br>
        <input type="checkbox" name="isNew"/> <br>
        <label>VIN number</label> <br>
        <input type="text" name="vin"/> <br>
        <label>Main Photo</label> <br>
        <input type="url" name="photoUrl"/> <br>

        <label>Photos</label> <br>
        <input /> <br>

        <button type="submit">Submit</button>
    </form>
</body>
</html>