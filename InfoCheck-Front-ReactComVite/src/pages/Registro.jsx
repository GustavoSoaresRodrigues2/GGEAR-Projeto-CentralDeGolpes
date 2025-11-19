import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { apiPost } from "../api";

function Registro() {
    const navigate = useNavigate();

    const [form, setForm] = useState({
        nome: "",
        cpf: "",
        senha: "",
        cep: "",
        dataNascimento: "",
    });

    const [loading, setLoading] = useState(false);

    function handleChange(e) {
        const { name, value } = e.target;
        setForm(prev => ({ ...prev, [name]: value }));
    }

    async function handleRegistro(e) {
        e.preventDefault();
        setLoading(true);

        // 1️⃣ log do formulário antes de enviar
        console.log("Form antes de enviar:", form);

        const body = {
            nome: form.nome.trim(),
            cpf: form.cpf.trim(),
            senha: form.senha.trim(),
            cep: form.cep.trim(),
            dataNascimento: form.dataNascimento, // nome do campo no DTO
        };

        console.log("Body que será enviado:", body);

        try {
            const resp = await apiPost("/api/usuarios/registro", body);

            // 2️⃣ log da resposta da API
            console.log("Resposta da API:", resp);

            alert("Usuário registrado com sucesso!");
            navigate("/login");
        } catch (err) {
            // 3️⃣ log detalhado do erro
            console.error("Erro ao registrar:", err);

            // opcional: log do status HTTP se disponível
            if (err.response) {
                console.error("Status HTTP:", err.response.status);
                console.error("Corpo da resposta:", err.response.data);
            }

            alert("Erro ao registrar usuário. Verifique os dados e tente novamente.");
        } finally {
            setLoading(false);
        }
    }


    return (
        <div className="container">
            <div className="card">
                <h1>Registro</h1>
                <form onSubmit={handleRegistro} className="form">
                    <label>
                        Nome:
                        <input type="text" name="nome" value={form.nome} onChange={handleChange} required />
                    </label>

                    <label>
                        CPF:
                        <input type="text" name="cpf" value={form.cpf} onChange={handleChange} required />
                    </label>

                    <label>
                        Data de Nascimento:
                        <input type="date" name="dataNascimento" value={form.dataNascimento} onChange={handleChange} required />
                    </label>

                    <label>
                        CEP:
                        <input type="text" name="cep" value={form.cep} onChange={handleChange} required />
                    </label>

                    <label>
                        Senha:
                        <input type="password" name="senha" value={form.senha} onChange={handleChange} required />
                    </label>

                    <button type="submit" disabled={loading}>
                        {loading ? "Registrando..." : "Registrar"}
                    </button>
                </form>

                <p className="link-alt">
                    Já tem conta? <Link to="/login">Faça login</Link>
                </p>
            </div>
        </div>
    );
}

export default Registro;
