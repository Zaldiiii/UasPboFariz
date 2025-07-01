<%@ page import="java.util.*, com.fariz.webappml.model.Hero" %>
<%
    List<Hero> list = (List<Hero>) request.getAttribute("listHero");
%>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Daftar Hero</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #0f2027, #203a43, #2c5364);
            color: #f4f4f4;
        }

        .container {
            max-width: 900px;
            margin: 50px auto;
            padding: 30px;
            background-color: #1c1c1e;
            border-radius: 10px;
            box-shadow: 0 4px 16px rgba(0,0,0,0.6);
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            font-weight: 600;
            color: #00d9ff;
        }

        .add-btn {
            display: block;
            width: fit-content;
            padding: 12px 20px;
            background-color: #0984e3;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-weight: 500;
            margin-bottom: 20px;
            transition: background-color 0.3s ease;
        }

        .add-btn:hover {
            background-color: #74b9ff;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #2a2a2c;
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 14px;
            text-align: center;
            border-bottom: 1px solid #444;
        }

        th {
            background-color: #111;
            color: #00d9ff;
            font-weight: 600;
        }

        tr:hover {
            background-color: #333;
        }

        .action-link {
            color: #00cec9;
            text-decoration: none;
            margin: 0 6px;
            font-weight: 500;
        }

        .action-link:hover {
            text-decoration: underline;
            color: #81ecec;
        }

        .no-data {
            text-align: center;
            color: #ccc;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Daftar Hero Mobile Legend</h2>
    <a href="form.jsp" class="add-btn">+ Tambah Hero</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Nama</th>
            <th>Kategori</th>
            <th>Gender</th>
            <th>Aksi</th>
        </tr>
        <%
            if (list != null && !list.isEmpty()) {
                for (Hero h : list) {
        %>
        <tr>
            <td><%= h.getIdHero() %></td>
            <td><%= h.getNamaHero() %></td>
            <td><%= h.getKategori() %></td>
            <td><%= h.getGender() %></td>
            <td>
                <a class="action-link" href="HeroServlet?action=edit&id=<%= h.getIdHero() %>">Edit</a>
                <a class="action-link" href="HeroServlet?action=delete&id=<%= h.getIdHero() %>"
                   onclick="return confirm('Yakin ingin hapus?')">Hapus</a>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5" class="no-data">Data tidak tersedia</td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
