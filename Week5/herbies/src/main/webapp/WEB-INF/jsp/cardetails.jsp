<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/cardetail.css" />
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <h1>${car.manufacturerName} ${car.model} Details</h1>


<div class="carouselsize">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-touch="true">
        <div class="carousel-inner">
            <!-- using for each loop to iterate through the photos associated with the car object -->
            <!-- varStatus="status" lets us track the iteration status -->
            <c:forEach var="photo" items="${car.photos}" varStatus="status">
                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                    <!-- loading each photo -->
                    <img class="d-block w-100" src="${photo.photoUrl}" alt="Car photo"/>
                </div>
            </c:forEach>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    
</div>
<div class="cardetailscontent">
    <label>Manufacturer Name:</label>
    <p>${car.manufacturerName}</p>
    <label>Model:</label>
    <p>${car.model}</p>
    <label>Transmission:</label>
    <p>${car.transmission}</p>
    <label>Color:</label>
    <p>${car.color}</p>
    <label>Mileage:</label>
    <p>${car.mileage}</p>
    <label>Description:</label>
    <p>${car.description}</p>
    <label>Body Style:</label>
    <p>${car.bodyStyle}</p>

    <a href="/cart/add/${car.id}"><button>Add To Cart</button></a>

</div>
</body>
</html>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>