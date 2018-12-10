<html>
<body>
	<h1>Car Hire Registration Form</h1>

	<form action="webapi/myresource" method="post">
		<p>
			Name: <input type="text" name="name" />
		</p>
		<p>
			Phone Number: <input type="text" name="phoneNumber" />
		</p>
		
		<p>
			City: <input type="text" name="city" />
		</p>
		
		<p>
			Country: <input type="text" name="country" />
		</p>
		
		<p>  Cars Available 
		<select name="car">
    <option value="volvo">Volvo</option>
    <option value="saab">Saab</option>
    <option value="fiat">Fiat</option>
    <option value="audi">Audi</option>
    <option value="audi">Bmw</option>
  </select>
		</p>
		
		<input type="submit" value="Submit" />
	</form>
<form action="webapi/customers" method="get">
<p> Show Database </p>

	
		<input type="submit" value="Display" />
</form>

</body>
</html>