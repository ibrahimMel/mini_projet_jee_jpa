<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #2c3e50, #4ca1af);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Segoe UI', sans-serif;
            color: white;
        }

        .login-box {
            background: rgba(255, 255, 255, 0.05);
            backdrop-filter: blur(15px);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 0 25px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 400px;
        }

        .login-box h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .form-control {
            background-color: rgba(255,255,255,0.1);
            border: none;
            color: white;
        }

        .form-control::placeholder {
            color: rgba(255,255,255,0.6);
        }

        .btn-primary {
            background: #00cec9;
            border: none;
        }

        .btn-primary:hover {
            background: #00b894;
        }

        .alert-danger {
            background-color: rgba(255, 0, 0, 0.2);
            color: white;
            border: none;
        }

        label {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<div class="login-box">
    <h2>Connexion</h2>

    <form method="post" action="login">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <div class="mb-3">
            <label for="username">Nom d'utilisateur</label>
            <input type="text" name="username" id="username" class="form-control" placeholder="Votre login" required>
        </div>

        <div class="mb-3">
            <label for="password">Mot de passe</label>
            <input type="password" name="password" id="password" class="form-control" placeholder="Votre mot de passe" required>
        </div>

        <button type="submit" class="btn btn-primary w-100">Se connecter</button>
    </form>
</div>
</body>
</html>
