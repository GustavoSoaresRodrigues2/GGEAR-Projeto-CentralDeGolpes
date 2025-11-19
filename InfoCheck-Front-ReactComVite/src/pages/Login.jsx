import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { apiPost } from "../api";

function Login() {
  const navigate = useNavigate();
  const [cpf, setCpf] = useState("");
  const [senha, setSenha] = useState("");
  const [erro, setErro] = useState("");
  const [loading, setLoading] = useState(false);

  async function handleLogin(e) {
    e.preventDefault();
    setErro("");
    setLoading(true);

    try {
      const body = { cpf, senha };
      const resp = await apiPost("/api/usuarios/login", body);

      if (!resp || !resp.id_usuario) {
        setErro("CPF ou senha inválidos.");
        setLoading(false);
        return;
      }

      localStorage.setItem("usuarioLogado", JSON.stringify(resp));
      navigate("/dashboard");
    } catch (err) {
      console.error(err);
      setErro("Erro ao tentar fazer login. Verifique o servidor.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="container">
      <div className="card">
        <h1>Login</h1>

        <form onSubmit={handleLogin} className="form">
          <label>
            CPF:
            <input
              type="text"
              value={cpf}
              onChange={(e) => setCpf(e.target.value)}
              placeholder="000.000.000-00"
              required
            />
          </label>

          <label>
            Senha:
            <input
              type="password"
              value={senha}
              onChange={(e) => setSenha(e.target.value)}
              required
            />
          </label>

          {erro && <p className="error">{erro}</p>}

          <button type="submit" disabled={loading}>
            {loading ? "Entrando..." : "Entrar"}
          </button>
        </form>

        <p className="link-alt">
          Não tem conta? <Link to="/registro">Registre-se aqui</Link>
        </p>
      </div>
    </div>
  );
}

export default Login;
