import React from 'react'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function SignIn(props) {



  const navigator = useNavigate();


  //this function is designed to handle any changes that occur within the form's input fields. 
  //it's triggerd whenever the user types in an input
  const signInChangeHandler = (event) => {

    //get the name attribute of the input field
    const name = event.target.name;

    let value;

    value = event.target.value;

    //create a copy of the user object from props
    //we create a tempuser object because we never want to directly modify the original prop user object
    const tempUser = {...props.user};

    //update the corresponding property in the temporary user object with the new value
    tempUser[name] = value;
    console.log("Updated user object", tempUser);

    //update the state with the modified user object
    props.setUser(tempUser);
    console.log("User state updated with new value");
  

  };



  //this function is called when the user click the submit button
    const signInSubmitHandler = () => {

        //make a post request to the server with the user data
      axios.post("http://localhost:8080/signin", props.user)
      //defines what happens if the server responds successfully to the post request
        .then((response) => {

          //stores the user's id(which might be part of the data returned by the server in response.data) in the browsers local storage. this is helpful to keep track of the logged-in user
          localStorage.setItem("userID", response.data.id); //store the user id in local storage
          //update the user state in the parent component with the data received from the server's response
          props.setUser(response.data);
          navigator("/");

        })
        .catch((e) => {
          console.log(e);
        })


    };




    
  return (
   
    <>

<html class="h-full bg-white">
        <body class="h-full">

    <div className="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
    <div className="sm:mx-auto sm:w-full sm:max-w-sm">
      <img
        alt="Your Company"
        src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=600"
        className="mx-auto h-10 w-auto"
      />
      <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
        Sign in to your account
      </h2>
    </div>

    <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
      <div className="space-y-6">
        <div>
          <label htmlFor="email" className="block text-sm font-medium leading-6 text-gray-900">
            Email address
          </label>
          <div className="mt-2">
            <input
              id="email"
              name="email"
              type="email"
              required
              autoComplete="email"
              className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              onChange={signInChangeHandler}
            />
          </div>
        </div>

        <div>
          <div className="flex items-center justify-between">
            <label htmlFor="password" className="block text-sm font-medium leading-6 text-gray-900">
              Password
            </label>
            <div className="text-sm">
              <a href="#" className="font-semibold text-indigo-600 hover:text-indigo-500">
                Forgot password?
              </a>
            </div>
          </div>
          <div className="mt-2">
            <input
              id="password"
              name="password"
              type="password"
              required
              autoComplete="current-password"
              className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              onChange={signInChangeHandler}
            />
          </div>
        </div>

        <div>
          <button
         
            className="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
            onClick={signInSubmitHandler}
          >
            Sign in
          </button>
        </div>
      </div>

      <p className="mt-10 text-center text-sm text-gray-500">
        Not a member?{' '}
        <a href="#" className="font-semibold leading-6 text-indigo-600 hover:text-indigo-500">
          Start a 14 day free trial
        </a>
      </p>
    </div>
  </div>

</body>
</html>
  </>
  )
}

export default SignIn