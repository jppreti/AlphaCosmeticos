<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:dev="http://compdevbooks.com.br/alphacosmetics"
				xmlns:ent="http://compdevbooks.com.br/alphacosmetics/ClienteEntity">
	<xsl:template match="/">

	<html>
		<head>
			<title>Clientes</title>
		</head>
		<body>
			<table>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Telefone</th>
				</tr>
				<xsl:for-each select="ent:clientes/ent:ClienteEntity">
				<tr>
					<td><xsl:value-of select="dev:nome" /></td>
					<td><xsl:value-of select="dev:email" /></td>
					<td><xsl:value-of select="dev:telefone" /></td>
				</tr>
				</xsl:for-each>
			</table>
		</body>
	</html>

	</xsl:template>
</xsl:stylesheet>