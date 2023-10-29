import { Route, Routes, useNavigate } from "react-router-dom";
import React, { useEffect, useState } from 'react';
import UserList from "./UserList";
import 'bootstrap/dist/css/bootstrap.min.css';
import Compte from "./Compte";
import Mouvement from "./Mouvement";
import Login from "./Login";
import axios from 'axios';
import Header from "./Header";
import './Login.scss';
import { Spinner } from "react-bootstrap";

export const AUTH_TOKEN_KEY = 'jhi-authenticationToken';

const UserConnected = ({ setUserInfo, userInfo }) => {
    const history = useNavigate();
    React.useEffect(() => {
        setUserInfo(null);
        axios.get('/isConnected').then(response => {
            setUserInfo(response.data);
        }).catch(err => {
            console.error('failed to get user');
            // Redirect to /login when userInfo is undefined
            history('/login');
        });
    }, [history, setUserInfo]);

    return (
        <>
            {userInfo && <Header userInfo={userInfo} setUserInfo={setUserInfo} />}
        </>
    );
}

function App() {
    const [userInfo, setUserInfo] = useState('');
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        // Add an Axios interceptor to check if userInfo is undefined and redirect to /login
        axios.interceptors.request.use(function (request) {
            const token = sessionStorage.getItem(AUTH_TOKEN_KEY);
            if (token) {
                request.headers.Authorization = `Bearer ${token}`;
            }
            setLoading(true);
            return request;
        }, (error) => {
            setLoading(false);
            return Promise.reject(error);
        });

        axios.interceptors.response.use(function (response) {
            setLoading(false);
            return response;
        }, (error) => {
            setLoading(false);
            if (error.response && error.response.status === 401) {
                // Unauthorized error, userInfo is undefined, redirect to /login
                window.location.href = '/login';
            }
            return Promise.reject(error);
        });
    });

    return (
        <div id="page">
            {loading && (
                <div className="background-spinner">
                    <div className="spinner">
                        <Spinner animation="grow" variant="light" />
                    </div>
                </div>
            )}
            <UserConnected userInfo={userInfo} setUserInfo={setUserInfo} />
            <div id="content">
                <Routes>
                    <Route exact path="/" element={<UserList />} />
                    <Route path="/compte/:compteId" element={<Compte />} />
                    <Route path="/mouvements/:compteId" element={<Mouvement />} />
                    <Route path="/login" element={<Login setUserInfo={setUserInfo} />} />
                    <Route path="*" element={<Login setUserInfo={setUserInfo} />} />
                </Routes>
            </div>
        </div>
    );
}

export default App;
