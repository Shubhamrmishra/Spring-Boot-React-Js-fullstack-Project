import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link, useNavigate, useParams } from 'react-router-dom'

export default function ViewUser() {

    let navigate=useNavigate();

   const{id}=useParams()
   
    const{name, username, email} =user

    const onInputChange=(e)=>{

        setUser({...user, [e.target.name]:e.target.value})
    }

    useEffect(()=>{
        loadUser();
    }, []);

    const onSubmit=async(e)=>{
        e.preventDefault();
        await axios.get(`http://localhost:8081/user/${id}`, user)
        navigate("/");

    }

    const loadUser = async ()=>{
        const result=await axios.get(`http://localhost:8081/user/${id}`)
        setUser(result.data)
    }

    
  return (
    <div className="container">
        <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="test-center m-4">User Details</h2>
<div className="card">
    <div className="card-header">
        deatils of user id is :
        <ul className="list-group list-group-flush">
            <li className="list-group-item">
                <b>Name: {user.name}</b>
                </li>
                <li className="list-group-item">
                    <b>UserName: </b>
                </li>
                <li className="list-group-item">
                    <b>Email: </b>
                    </li>
        </ul>
    </div>
</div>

        <Link className="btn btn-primary my-2" to={"/"}><b>Back to Home</b></Link>

                </div>
                </div>

                <p>hii this is shubham</p>

    </div>


  )
}
