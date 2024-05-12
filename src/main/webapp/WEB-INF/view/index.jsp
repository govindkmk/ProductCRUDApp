<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
</head>
<body>

	<div class="container mt-3">

		<div class="row">

			<div class="col-md-12">

				<h1 class="text-center mb-3">Welcome to Product Management App</h1>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">S.No.</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products }" var="p">
						<tr>
							<th scope="row">LAP${p.id}</th>
							<td>${p.name }</td>
							<td>${p.description }</td>
							<td class="fw-bold">Rs ${p.price }</td>
							<td>
								<a href="delete/${p.id}"><i class="fa-regular fa-trash-can text-danger" style="font-size: 20px"></i></a>
								<a href="update/${p.id}"><i class="fa-solid fa-pen-to-square text-warning" style="font-size: 20px"></i></a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="container text-center">
					<a href="add-Product" class="btn btn-outline-success">Add Product</a>
				</div>
			</div>

		</div>


	</div>
</body>
</html>
