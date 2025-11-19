// src/pages/Dashboard.jsx
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function Dashboard() {
  const navigate = useNavigate();
  const [usuario, setUsuario] = useState(null);

  useEffect(() => {
    const stored = localStorage.getItem("usuarioLogado");
    if (!stored) {
      navigate("/login");
      return;
    }

    try {
      const parsed = JSON.parse(stored);
      setUsuario(parsed);
    } catch (e) {
      console.error("Erro ao ler usuário do localStorage:", e);
      localStorage.removeItem("usuarioLogado");
      navigate("/login");
    }
  }, [navigate]);

  function handleLogout() {
    localStorage.removeItem("usuarioLogado");
    navigate("/login");
  }

  if (!usuario) return null;

  return (
    <div className="container">
      <div className="card">
        <h1>Área Logada</h1>
        <p>
          Bem-vindo, <strong>{usuario.nome}</strong>!
        </p>

        <div className="dados-usuario">
          <p>
            <strong>CPF:</strong> {usuario.cpf}
          </p>
          <p>
            <strong>CEP:</strong> {usuario.cep}
          </p>
        </div>

        <button type="button" onClick={handleLogout}>
          Sair
        </button>
      </div>
    </div>
  );
}

export default Dashboard;
