import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

function formatDateTime(date) {
    const options = { year: "numeric", month: "numeric", day: "numeric", hour: "numeric", minute: "numeric" };
    return new Intl.DateTimeFormat("fr-FR", options).format(new Date(date));
}

function Mouvement() {
    const { compteId } = useParams();
    const [mouvements, setMouvements] = useState([]);

    useEffect(() => {
        axios
            .get(`/mouvements/compte/${compteId}`)
            .then((response) => {
                setMouvements(response.data);
            })
            .catch((error) => {
                console.error("Erreur lors de la récupération des mouvements : " + error);
            });
    }, [compteId]);

    return (
        <div className="container">
            <div className="mouvement-list mt-4">
                <h2 className="mb-4">Liste des mouvements associés au compte</h2>
                {mouvements.length === 0 ? (
                    <p>Aucun mouvement disponible pour ce compte.</p>
                ) : (
                    <ul className="list-group">
                        {mouvements.map((mouvement) => (
                            <li key={mouvement.id} className="list-group-item">
                                <p>Date : {formatDateTime(mouvement.date)}</p>
                                <p>Référence : {mouvement.reference}</p>
                                <p>Solde : {mouvement.solde}</p>
                                <p>Type de mouvement : {mouvement.typeMouvement}</p>
                            </li>
                        ))}
                    </ul>
                )}
            </div>

            <Link to={`/compte/${compteId}`} className="btn btn-primary mt-4">
                Retour
            </Link>
        </div>
    );
}

export default Mouvement;
