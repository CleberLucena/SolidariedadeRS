const express = require('express');
const app = express();
const port = 3000;

const {
  addPosto,
  getPostos,
  addNumeroEmergencia,
  getNumerosEmergencia,
  addMensagemSolidariedade,
  getMensagensSolidariedade
} = require('./firebase.js');

// Middleware para interpretar JSON no corpo das requisições.
app.use(express.json());

// ===== Endpoints para Postos de Doação =====

// Adicionar um posto de doação
app.post('/api/postos', async (req, res) => {
  try {
    const posto = req.body;
    await addPosto(posto);
    res.status(200).json({ success: true });
  } catch (error) {
    console.error("Erro ao adicionar posto:", error);
    res.status(500).json({ success: false, error: error.message });
  }
});

// Obter a lista de postos de doação
app.get('/api/postos', async (req, res) => {
  try {
    const postos = await getPostos();
    res.status(200).json(postos);
  } catch (error) {
    console.error("Erro ao obter postos:", error);
    res.status(500).json({ success: false, error: error.message });
  }
});

// ===== Endpoints para Números de Emergência =====

// Adicionar um número de emergência
app.post('/api/emergencias', async (req, res) => {
  try {
    const emergencia = req.body;
    await addNumeroEmergencia(emergencia);
    res.status(200).json({ success: true });
  } catch (error) {
    console.error("Erro ao adicionar número de emergência:", error);
    res.status(500).json({ success: false, error: error.message });
  }
});

// Obter a lista de números de emergência
app.get('/api/emergencias', async (req, res) => {
  try {
    const emergencias = await getNumerosEmergencia();
    res.status(200).json(emergencias);
  } catch (error) {
    console.error("Erro ao obter números de emergência:", error);
    res.status(500).json({ success: false, error: error.message });
  }
});

// ===== Endpoints para Mensagens de Solidariedade =====

// Adicionar uma mensagem de solidariedade
app.post('/api/mensagens', async (req, res) => {
  try {
    const mensagem = req.body;
    await addMensagemSolidariedade(mensagem);
    res.status(200).json({ success: true });
  } catch (error) {
    console.error("Erro ao adicionar mensagem:", error);
    res.status(500).json({ success: false, error: error.message });
  }
});

// Obter a lista de mensagens de solidariedade
app.get('/api/mensagens', async (req, res) => {
  try {
    const mensagens = await getMensagensSolidariedade();
    res.status(200).json(mensagens); 
  } catch (error) {
    console.error("Erro ao obter mensagens:", error);
    res.status(500).json({ success: false, error: error.message });
  }
});

// Inicia o servidor na porta definida.
app.listen(port, () => {
  console.log(`Servidor rodando na porta ${port}`);
});
