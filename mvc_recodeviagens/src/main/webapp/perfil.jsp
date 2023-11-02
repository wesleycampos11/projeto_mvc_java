<%@page import="model.Usuario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta charset="ISO-8859-1">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- ICON GO TO -->
<link rel="shortcut icon" href="img/icon_goto.png" type="image/x-icon">

<!-- BOOTSTRAP -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- GOOGLE ICON -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<!-- CSS EXTERNO -->
<link rel="stylesheet" href="css/profile.css">

<title>Perfil | In�cio</title>
</head>
<body>

	

	<header class="container">

		<div class="row container p-2">

			<div class="col-md-3 mt-2 mb-2 logo">

				

			</div>

			<div
				class="col-md-7 d-flex flex-column align-items-start justify-content-center">

				<!-- PEGA O ATRIBUTO QUE EST� DENTRO DA SESS�O LOGADO -->
				<%
				Usuario u = (Usuario) session.getAttribute("usuarioLogado");
				// out.print(u.getNome());
				%>

				<span>Ol�, <strong><%=u.getNome()%></strong>. Seja bem vindo(a)!	</span>

				<div class="datahora">
					<span><strong>Data:</strong> <span id="data"></span>.</span> <span><strong>Hora:</strong>
						<span id="hora"></span>.</span>
				</div>

			</div>

			<div
				class="col-md-2 text-light d-flex align-items-center justify-content-end mt-2 mb-2">

				<a href="index.html"> <span class="material-symbols-outlined logout">logout</span>
				</a>

			</div>

		</div>

	</header>


	<div class="container grid-container">

		<div class="menu">

			<ul>
				<a href="#"> <span class="material-symbols-outlined">
						home </span>

					<li>In�cio</li>

				</a>

				<a href="minhasviagens.jsp"> <span
					class="material-symbols-outlined"> flight </span>

					<li>Minhas viagens</li>

				</a>

				<a href="comprarpassagem.jsp"> <span
					class="material-symbols-outlined"> shopping_cart_checkout </span>

					<li class="viagens">Comprar passagem</li>
				</a>

				<a href="infocadastrais.jsp"> <span
					class="material-symbols-outlined"> info </span>

					<li>Info. Cadastrais</li>
				</a>

				<a href="excluirconta.jsp"> <span
					class="material-symbols-outlined"> cancel </span>

					<li>Excluir minha conta</li>
				</a>
				
				
				<a href="index.html"> <span
					class="material-symbols-outlined"> home </span>

					<li>Home</li>
				</a>

			</ul>

		</div>


		<div class="principal">

			<h2 class="text-center mt-2 mb-2">P�gina inicial</h2>
			<p class="text-center text-danger">Utilize os menus laterais para
				navegar pelo perfil.</p>

		</div>


	</div>

	<script src="js/perfil.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	       
</body>
</html>