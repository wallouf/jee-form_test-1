<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css" />" />
    </head>
    <body>
        <form method="post" action="<c:url value="/connexion" />">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
 
                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />
 
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />
 
                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                 
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                <c:if test="${!empty sessionScope.sessionUtilisateur }">
                	<p class="succes">Vous êtes connecté avec l'email : <c:out value="${sessionScope.sessionUtilisateur.email }" /></p>
                </c:if>
            </fieldset>
        </form>
    </body>
</html>