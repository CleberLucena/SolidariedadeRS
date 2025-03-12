// firebase.js (versão aprimorada)
const { initializeApp } = require('firebase/app');
const { getFirestore, collection, addDoc, getDocs } = require('firebase/firestore');

const firebaseConfig = {
    apiKey: "AIzaSyBuZili22Sez1Rei9R_JwqRQd81NPOX-YA",
    authDomain: "solidariedaders-4943f.firebaseapp.com",
    projectId: "solidariedaders-4943f",
    storageBucket: "solidariedaders-4943f.firebasestorage.app",
    messagingSenderId: "961172100264",
    appId: "1:961172100264:web:dd57d63a00075b13ebde9d",
    measurementId: "G-X294C1YPYZ"
};

const app = initializeApp(firebaseConfig);
const db = getFirestore(app);

async function addPosto(posto) {
    const docRef = await addDoc(collection(db, 'postos_doacao'), posto);
    console.log('Posto adicionado com ID:', docRef.id);
    return docRef;
}

async function getPostos() {
    const querySnapshot = await getDocs(collection(db, 'postos_doacao'));
    const postos = [];
    querySnapshot.forEach((doc) => {
        postos.push({ id: doc.id, ...doc.data() });
    });
    return postos;
}

async function addNumeroEmergencia(numero) {
    const docRef = await addDoc(collection(db, 'numeros_emergencia'), numero);
    console.log('Número de emergência adicionado com ID:', docRef.id);
    return docRef;
}

async function getNumerosEmergencia() {
    const querySnapshot = await getDocs(collection(db, 'numeros_emergencia'));
    const numeros = [];
    querySnapshot.forEach((doc) => {
        numeros.push({ id: doc.id, ...doc.data() });
    });
    return numeros;
}

async function addMensagemSolidariedade(mensagem) {
    const docRef = await addDoc(collection(db, 'mensagens_solidariedade'), mensagem);
    console.log('Mensagem de solidariedade adicionada com ID:', docRef.id);
    return docRef;
}

async function getMensagensSolidariedade() {
    const querySnapshot = await getDocs(collection(db, 'mensagens_solidariedade'));
    const mensagens = [];
    querySnapshot.forEach((doc) => {
        mensagens.push({ id: doc.id, ...doc.data() });
    });
    return mensagens;
}
module.exports = {
    db,
    addPosto,
    getPostos,
    addNumeroEmergencia,
    getNumerosEmergencia,
    addMensagemSolidariedade,
    getMensagensSolidariedade
};
