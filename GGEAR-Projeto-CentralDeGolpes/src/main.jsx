import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

import Login from './pages/Login.jsx'
import TelaPrincipal from './pages/TelaPrincipal.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/pages" element={<TelaPrincipal />} />
      </Routes>
    </BrowserRouter>
  </StrictMode>
)
