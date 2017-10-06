<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>

<head>
	<title>SuperHero</title>
</head>
<body>

	<div id="title" align="center">
		<h1>Saisissez vos données</h1>
	</div>
	<hr />
	<hr />

	<s:bean name="app.hm.entities.SuperHero" id="superHero">
		<div id="title" align="center">
			<s:form action="SuperHeroController.action" >
				<s:textfield name="superHero.alias" label="nom" value="%{superHero.nom}"/>
				<br></br>
				<s:textfield name="superHero.caracteristique.eau" label="age" value="%{superHero.caracteristique.eau}"/>
				<br></br>
				
				<fieldset> 
					 <s:submit method="validate" />
				</fieldset>
			</s:form>
<%-- 			<s:if test="personne.statut != null"> --%>
<%-- 				<h1><s:property value="personne.statut" /></h1> --%>
<%-- 			</s:if> --%>
		</div>
	</s:bean>

</body>


</html>