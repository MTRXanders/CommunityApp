import React, { useEffect } from 'react';
import {
  MDBRow,
  MDBCol,
  MDBInput,
  MDBCheckbox,
  MDBBtn
} from 'mdb-react-ui-kit';
import {userService } from '../services/ServiceConfiguration.js';
import User from '../models/User.js';


export default function UserForm() {
    const name = React.createRef();
    const lastName = React.createRef();
    const address = React.createRef();
    const email = React.createRef();
    const password = React.createRef();
    const telephone = React.createRef();
    function submitClick(e) {
        e.preventDefault();
        console.log(name.current.value);
        userService.create(new User(
            name.current.value,
            lastName.current.value,
            address.current.value,
            email.current.value,
            password.current.value,
            telephone.current.value)
        )
    }


    useEffect(() => {

    })

  return (
    <form>
      <MDBRow className='mb-4'>
        <MDBCol>
          <MDBInput id='form6Example1' inputRef={name} label='First name' />
        </MDBCol>
        <MDBCol>
          <MDBInput id='form6Example2' inputRef={lastName} label='Last name' />
        </MDBCol>
      </MDBRow>

      {/* <MDBInput wrapperClass='mb-4' id='form6Example3' label='Company name' /> */}
      <MDBInput wrapperClass='mb-4' id='form6Example4' inputRef={address} label='Address' />
      <MDBInput wrapperClass='mb-4' type='email' id='form6Example5' inputRef={email} label='Email' />
      <MDBInput wrapperClass='mb-4' type='tel' id='form6Example6' inputRef={telephone} label='Phone' />
      <MDBInput wrapperClass='mb-4' type='password' id='form6Example7' inputRef={password} label='Password' />

      {/* <MDBInput wrapperClass='mb-4' textarea='true' id='form6Example7' rows={4} label='Additional information' /> */}

      {/* <MDBCheckbox
        wrapperClass='d-flex justify-content-center mb-4'
        id='form6Example8'
        label='Create an account?'
        defaultChecked
      /> */}

      <MDBBtn onClick={submitClick} className='mb-4' type='submit' block>
        Submit
      </MDBBtn>
    </form>
  );
}