const {
    db,
    addPosto,
    getPostos,
    addNumeroEmergencia,
    getNumerosEmergencia,
    addMensagemSolidariedade,
    getMensagensSolidariedade
} = require('./firebase.js');

async function testPostos() {
    console.log('=== Testando Postos de Doação ===');
    await addPosto({
        nome: "Posto Central",
        endereco: "Rua das Flores, 123",
        cidade: "Porto Alegre",
        estado: "RS",
        localizacao: {
            latitude: -30.034647,
            longitude: -51.217658
        }
    });
    await getPostos();
}

async function testNumerosEmergencia() {
    console.log('=== Testando Números de Emergência ===');
    await addNumeroEmergencia({
        nome_orgao: "Defesa Civil",
        numero_telefone: "199"
    });
    await getNumerosEmergencia();
}

async function testMensagensSolidariedade() {
    console.log('=== Testando Mensagens de Solidariedade ===');
    await addMensagemSolidariedade({
        nome_usuario: "João Silva",
        estado_usuario: "SP",
        idade_usuario: 25,
        mensagem: "Força, Rio Grande do Sul! Estamos com vocês!",
        data_envio: new Date().toISOString()
    });
    await getMensagensSolidariedade();
}

async function runTests() {
    try {
        await testPostos();
        await testNumerosEmergencia();
        await testMensagensSolidariedade();
        console.log('=== Todos os testes foram concluídos ===');
    } catch (error) {
        console.error('Erro durante os testes:', error);
    }
}

runTests();