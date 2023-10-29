import React, { Component } from 'react';
import axios from 'axios';
import Compte from './Compte'; // Importez le composant Compte
import { Link } from "react-router-dom";
class UserList extends Component {
  constructor() {
    super();
    this.state = {
      users: [],
      selectedUserId: null,
      selectedUserCompte: null, // Ajoutez cet état pour stocker les détails du compte sélectionné
    };
  }

  componentDidMount() {
    // Effectuer une requête GET pour obtenir la liste des utilisateurs depuis votre backend
    axios.get('/users')
      .then(response => {
        this.setState({ users: response.data });
      })
      .catch(error => {
        console.error("Erreur lors de la récupération des utilisateurs : " + error);
      });
  }

  handleUserClick(compteId) {
    console.log("### this.props.history ###");
    console.log(this.props.history);
    //Navigate to Compte component
    this.props.history.push(`/compte/${compteId}`);
  }
  

  render() {
    return (
      <div className="container">
        <h1 className="mt-4">Liste des Utilisateurs</h1>
        <table className="table mt-4">
          <thead>
            <tr>
              <th>Nom</th>
              <th>Prénom</th>
              <th>Email</th>
              <th className="text-right">Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.state.users.map(user => (
              <tr key={user.id}>
                <td>{user.lastName}</td>
                <td>{user.firstName}</td>
                <td>{user.email}</td>
                <td className="text-right">
                <Link to={`/compte/${user.compteId}`} className="btn btn-primary">
                       Consulter le compte
               </Link>
                  
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        {this.state.selectedUserCompte && (
          <Compte compte={this.state.selectedUserCompte} />
        )}
      </div>
    );
  }
}

export default UserList;

