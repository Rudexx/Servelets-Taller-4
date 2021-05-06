<%--
  Created by IntelliJ IDEA.
  User: David Nogales
  Date: 5/5/2021
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>4-patas</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="css/estilos.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<%
%>


<section class="text-center" >

    <br>
    <br>
    <div id="visorArchivo">
        <!--Aqui se desplegará el fichero-->
    </div>


    <form action="save-image" method="post">

        <input type="file" id="archivoInput" class="col-md-offset-4 col-md-4"
               onchange="return validarExt()" required="true" name="image" />
        <br>
        <br>
        <label>  Inserte la descripción de la Fotografia</label>
        <br>
        <br>
        <textarea name="desc">  </textarea>
        <br>
        <br>
        <button type="submit" , id="enviarImagen"> Enviar Imágen</button>
    </form>
</section>

</body>
<script>
    function printTable(elementId, servlet, columns, actions = []) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);
                var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];
                data.map(d => {
                    var newRow = tbodyRef.insertRow();
                    columns.map(c => {
                        var cell = newRow.insertCell();
                        var text = document.createTextNode(d[c]);
                        cell.appendChild(text);
                    });
                    if (actions.includes('create-book')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('Create book');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }
                    if (actions.includes('delete-author')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('Delete author');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }
                });
            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);
    }
    // Printing libraries
    printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name']);
    // Printing authors
    printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId', 'name', 'numBooks'], actions = ['create-book', 'delete-author']);


</script>
<script type="text/javascript">
    function fn1()
    {
        var str = document.getElementById("Texto").value;
        alert("value inside the text box is:" + str);
    }

    function validarExt()

    {
        var archivoInput = document.getElementById('archivoInput');
        var archivoRuta = archivoInput.value;
        var extPermitidas = /(.jpg|.jpeg|.png|.gif)$/i;
        if(!extPermitidas.exec(archivoRuta)){
            alert('Sube un archivo que tenga las extensiones .jpeg / .jpg / .png / .gif solamente.');
            archivoInput.value = '';
            return false;
        }

        else
        {
            //PRevio de .jpeg / .jpg / .png / .gif
            if (archivoInput.files && archivoInput.files[0])
            {
                var visor = new FileReader();
                visor.onload = function(e)
                {
                    document.getElementById('visorArchivo').innerHTML =
                        '<embed src="'+e.target.result+'" width="500" height="375" />';
                };
                visor.readAsDataURL(archivoInput.files[0]);
            }
        }


    }

</script>
</html>
