<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Articles</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #2c3e50, #4ca1af);
            font-family: 'Segoe UI', sans-serif;
            color: white;
        }

        .container {
            margin-top: 40px;
        }

        h2 {
            font-weight: 700;
        }

        table {
            background-color: rgba(255,255,255,0.05);
            border-radius: 10px;
            overflow: hidden;
        }

        thead {
            background-color: rgba(0,0,0,0.2);
        }

        .form-control {
            background-color: rgba(255,255,255,0.1);
            border: none;
            color: white;
        }

        .form-control::placeholder {
            color: rgba(255,255,255,0.6);
        }

        .btn-success {
            background-color: #00cec9;
            border: none;
        }

        .btn-warning {
            background-color: #fdcb6e;
            border: none;
        }

        .btn-danger {
            background-color: #d63031;
            border: none;
        }

        .btn-outline-danger {
            border-color: #d63031;
            color: #d63031;
        }

        .btn-outline-danger:hover {
            background-color: #d63031;
            color: white;
        }

        .btn-outline-light {
            border-color: #ffffff88;
            color: white;
        }

        .btn-outline-light:hover {
            background-color: white;
            color: #2c3e50;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Articles</h2>
        <a href="logout" class="btn btn-outline-danger">Déconnexion</a>
    </div>

    <!-- Barre de recherche -->
    <form class="form-inline mb-3" method="get" action="articles">
        <input type="text" name="search" class="form-control me-2" placeholder="Recherche...">
        <button class="btn btn-primary" type="submit">Rechercher</button>
    </form>

    <!-- Formulaire d'ajout -->
    <form action="add-article" method="post" class="row g-2 mb-4">
        <div class="col-md-3">
            <input type="text" name="description" class="form-control" placeholder="Description" required>
        </div>
        <div class="col-md-2">
            <input type="number" name="price" step="0.01" class="form-control" placeholder="Prix" required>
        </div>
        <div class="col-md-2">
            <input type="number" name="quantite" class="form-control" placeholder="Quantité" required>
        </div>
        <div class="col-md-3">
            <input type="date" name="dateExpiration" class="form-control" required>
        </div>
        <div class="col-md-2">
            <button class="btn btn-success w-100">Ajouter</button>
        </div>
    </form>

    <!-- Boutons de tri par prix -->
    <div class="d-flex justify-content-end gap-2 mb-3">
        <form method="get" action="articles">
            <input type="hidden" name="sort" value="price_asc">
            <button class="btn btn-outline-light">⬆ Prix croissant</button>
        </form>
        <form method="get" action="articles">
            <input type="hidden" name="sort" value="price_desc">
            <button class="btn btn-outline-light">⬇ Prix décroissant</button>
        </form>
    </div>

    <!-- Tableau des articles -->
    <table class="table table-bordered table-hover text-white">
        <thead>
        <tr>
            <th>Description</th>
            <th>Prix</th>
            <th>Quantité</th>
            <th>Date Expiration</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="a" items="${articles}">
            <tr>
                <td>${a.description}</td>
                <td>${a.price}</td>
                <td>${a.quantite}</td>
                <td>${a.dateExpiration}</td>
                <td>
                    <button class="btn btn-sm btn-warning" data-bs-toggle="modal" data-bs-target="#editModal${a.id}">
                        Modifier
                    </button>
                    <a href="delete-article?id=${a.id}" class="btn btn-sm btn-danger"
                       onclick="return confirm('Supprimer cet article ?')">Supprimer</a>
                </td>
            </tr>

            <!-- Modal de modification -->
            <div class="modal fade" id="editModal${a.id}" tabindex="-1" aria-labelledby="editModalLabel${a.id}" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content bg-dark text-light">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editModalLabel${a.id}">Modifier Article</h5>
                            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Fermer"></button>
                        </div>
                        <form action="update-article" method="post">
                            <div class="modal-body">
                                <input type="hidden" name="id" value="${a.id}">
                                <div class="mb-3">
                                    <label>Description</label>
                                    <input type="text" name="description" class="form-control" value="${a.description}" required>
                                </div>
                                <div class="mb-3">
                                    <label>Prix</label>
                                    <input type="number" name="price" step="0.01" class="form-control" value="${a.price}" required>
                                </div>
                                <div class="mb-3">
                                    <label>Quantité</label>
                                    <input type="number" name="quantite" class="form-control" value="${a.quantite}" required>
                                </div>
                                <div class="mb-3">
                                    <label>Date d'expiration</label>
                                    <input type="date" name="dateExpiration" class="form-control" value="${a.dateExpiration}" required>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success">Enregistrer</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
