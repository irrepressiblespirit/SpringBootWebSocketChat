<#import "/spring.ftl" as spring/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Registration Page </title>
</head>
<body>
Add new user
<form id="registrForm" action="/registration" method="post" onSubmit="return validate(this)">
    <div><label> User Name : <input id="username" type="text" name="username" /> </label></div>
    <div><label> Password: <input id="password" v-model="password" type="password" name="password" /> </label></div>
    <div><label> Address: <input id="address" v-model="address" type="text" name="address"/> </label></div>
    <div><label> Phone number: <input id="phoneNumber" v-model="phoneNumber" type="text" name="phoneNumber" /> </label></div>
    <div><label> E-mail: <input id="email" v-model="email" type="text" name="email"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Add"/></div>
</form>
</body>
</html>