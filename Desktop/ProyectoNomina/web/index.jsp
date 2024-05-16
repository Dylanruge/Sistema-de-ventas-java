<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora de Nómina</title>
    <style>
        body {
            font-family: Arial, sans-serif;
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
        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
            font-weight: bold;
            text-align: left;
            font-size: 16px;
        }
        input[type="text"],
        input[type="number"],
        select {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }
        input[type="text"]:focus,
        input[type="number"]:focus,
        select:focus {
            outline: none;
            border-color: #007bff;
        }
        select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            background-image: url("data:image/svg+xml,%3Csvg width='18' height='12' viewBox='0 0 18 12' fill='%23007bff' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M1.5 1.5L9 9l7.5-7.5' stroke='%23007bff' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/svg%3E");
            background-repeat: no-repeat;
            background-position-x: 95%;
            background-position-y: 50%;
            padding-right: 30px;
        }
        button {
            width: 100%;
            padding: 12px 0;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
        .btn-group {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .btn-group button {
            width: 48%;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Calculadora de Nómina</h1>
        <form action="paginaDestino" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required>
            
            <label for="identificacion">Identificación:</label>
            <input type="text" id="identificacion" name="identificacion" required>
            
            <label for="salario">Salario Básico:</label>
            <select id="salario" name="salario" required>
                <option value="1300000">$1.300.000</option>
                <option value="1500000">$1.500.000</option>
                <option value="2000000">$2.000.000</option>
                <option value="2500000">$2.500.000</option>
                <option value="3000000">$3.000.000</option>
            </select>
            
            <label for="diasTrabajados">Días Trabajados:</label>
            <input type="number" id="diasTrabajados" name="diasTrabajados" min="1"
                   
                   max="30" required>
            
            <div class="btn-group">
                <button type="submit">Calcular</button>
                <button type="reset">Limpiar</button>
            </div>
            <input type="hidden" name="resultadoPage" value="resultado.jsp">
        </form>
    </div>
</body>
</html>
