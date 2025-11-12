import '../styles/FormLogin.css'

import { useNavigate } from 'react-router-dom'

function Login() {

  const navigate = useNavigate()

  const handleSubmit = (e) => {
    e.preventDefault() // impede o recarregamento da página

    // Aqui você pode validar o login, fazer requisições etc.
    // Depois que estiver tudo certo:
    navigate('/pages')
  }

  return (
    <>
      <main> 
        <form className='formLogin' onSubmit={handleSubmit}> {/*  */}
          <p className='formLogin_titulo'>Entre na sua conta</p>
          <div className='formInputs'>
            <input type="varchar" placeholder='Insira o seu CPF' />
            <span></span>
          </div>
          <div className='formInputs'>
            <input type="password" placeholder="Insira sua senha"></input>
          </div>
          <button type='submit' id='btnLogin' className='btn'>
            Entrar
          </button>
          <p className='cadastrar'>
            Sem cadastro?
            <a href="">Cadastre-se</a>
          </p>
        </form>
      </main>
    </>
  )
}

export default Login
