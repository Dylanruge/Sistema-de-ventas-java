<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultados de la Nómina</title>
    <style>
        body {
            font-family: times new roman, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            padding: 30px;
            max-width: 400px;
            width: 100%;
            text-align: center;
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
        }
        p {
            font-size: 16px;
            margin-bottom: 10px;
            text-align: left;
            color: #555;
        }
        strong {
            font-weight: bold;
            color: #333;
        }
        .resultado {
            margin-top: 20px;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Resultados de la Nómina</h1>
        <div class="resultado">
            <p><strong>Nombre:</strong> ${nombre}</p>
            <p><strong>Identificación:</strong> ${identificacion}</p>
            <p><strong>Salario:</strong> ${salario}</p>
            <p><strong>Descuento por Salud:</strong> ${salud}</p>
            <p><strong>Descuento por Pensión:</strong> ${pension}</p>
            <p><strong>Auxilio de Transporte:</strong> ${auxilioTransporte}</p>
            <p><strong>Neto a Pagar:</strong> ${netoPagar}</p>
        </div>
    </div>
</body>
</html>
