import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
import { Button, Modal, Form, Alert, Container, Row, Col } from "react-bootstrap";

function Compte() {
    const { compteId } = useParams();
    const [compte, setCompte] = useState(null);
    const [showModal, setShowModal] = useState(false);
    const [transactionAmount, setTransactionAmount] = useState(0);
    const [isDeposit, setIsDeposit] = useState(true);
    const [errorMessage, setErrorMessage] = useState(null);

    useEffect(() => {
        axios.get(`/comptes/${compteId}`)
            .then(response => {
                setCompte(response.data);
            })
            .catch(error => {
                console.error("Erreur lors de la récupération des données du compte : " + error);
            });
    }, [compteId]);

    const handleShowModal = () => setShowModal(true);
    const handleCloseModal = () => {
        setShowModal(false);
        setTransactionAmount(0);
        setErrorMessage(null);
    };

    const handleAddMoney = () => {
        axios.post("/comptes/modifyAccountBalance", {
            id: compte.id,
            transactionAmount,
            isDeposit: true
        })
            .then(response => {
                console.log("Ajout d'argent réussi :", response.data);
                handleCloseModal();
                updateAccountInfo();
            })
            .catch(error => {
                console.error("Erreur lors de l'ajout d'argent : " + error);
            });
    };



    const handleWithdrawMoney = () => {
        if (transactionAmount > compte.solde) {
            setErrorMessage("Solde insuffisant pour cette opération");
        } else {
            axios.post("/comptes/modifyAccountBalance", {
                id: compte.id,
                transactionAmount,
                isDeposit: false
            })
                .then(response => {
                    console.log("Retrait d'argent réussi :", response.data);
                    handleCloseModal();
                    updateAccountInfo();
                })
                .catch(error => {
                    console.error("Erreur lors du retrait d'argent : " + error);
                });
        }
    };

    const updateAccountInfo = () => {
        axios.get(`/comptes/${compteId}`)
            .then(response => {
                setCompte(response.data);
            })
            .catch(error => {
                console.error("Erreur lors de la mise à jour des données du compte : " + error);
            });
    };

    if (!compte) {
        return <div className="alert alert-info">Chargement en cours...</div>;
    }

    return (
        <Container>
            <div className="compte-details mt-4">
                <h2>Informations du compte</h2>
                <p>ID du compte : {compte.id}</p>
                <p>Statut : {compte.statut}</p>
                <p className="font-weight-bold">Agence : {compte.agence}</p>
                <p className="font-weight-bold">RIB : {compte.rib}</p>
                <p className="font-weight-bold">Devise : {compte.devise}</p>
                <p className="font-weight-bold">Intitulé : {compte.intitule}</p>
                <p className="font-weight-bold">Solde : {compte.solde}</p>
                <p className="font-weight-bold">Type de compte : {compte.typeCompte}</p>

                <Row className="mt-4">
                    <Col md={3}>
                        <Link to="/" className="btn btn-primary">
                            Retour
                        </Link>
                    </Col>
                    <Col md={3}>
                        <Button variant="primary" onClick={() => {setIsDeposit(true); handleShowModal();}}>
                            Ajouter argent
                        </Button>
                    </Col>
                    <Col md={3}>
                        <Button variant="danger" onClick={() => {setIsDeposit(false); handleShowModal();}}>
                            Retirer argent
                        </Button>
                    </Col>
                    <Col md={3}>
                        <Link to={`/mouvements/${compte.id}`} className="btn btn-primary">
                            Consulter les mouvements
                        </Link>
                    </Col>
                </Row>
            </div>

            <Modal show={showModal} onHide={handleCloseModal}>
                <Modal.Header closeButton>
                    <Modal.Title>{isDeposit ? "Ajouter de l'argent" : "Retirer de l'argent"}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Form.Label>Montant</Form.Label>
                            <Form.Control
                                type="number"
                                placeholder="Montant"
                                value={transactionAmount}
                                onChange={(e) => setTransactionAmount(e.target.value)}
                            />
                        </Form.Group>
                    </Form>
                    {errorMessage && <Alert variant="danger">{errorMessage}</Alert>}
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleCloseModal}>
                        Annuler
                    </Button>
                    <Button variant="primary" onClick={isDeposit ? handleAddMoney : handleWithdrawMoney}>
                        Valider
                    </Button>
                </Modal.Footer>
            </Modal>
        </Container>
    );
}

export default Compte;
