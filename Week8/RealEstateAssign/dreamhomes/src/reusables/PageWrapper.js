import React from 'react'
import Header from './Header'


//the purpose of a pagewrapper is to provide a consistent structure and behavior to different parts of the application
//it can include common elements like headers, footers, navigatio bars, side bars, i.e. elements that appear on multiple pages
function PageWrapper(props) {

  return (
    <div>
        <Header user={props.user} setUser = {props.setUser}/>
        {/* props.children is being used to render whatever components are nested within "PageWrapper" when it is used */}
        <div>{props.children}</div>
    </div>
  )
}

export default PageWrapper


// The PageWrapper component wraps around the Routes component in App.js.
// The Routes component and all its nested routes (like Home, SignIn, SignUp, etc.) are passed to PageWrapper as props.children.
// Inside PageWrapper, props.children renders the Routes component, allowing different page content to be displayed within the common layout that includes the Header.