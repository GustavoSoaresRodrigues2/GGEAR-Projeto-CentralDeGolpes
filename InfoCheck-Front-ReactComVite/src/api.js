export const API_BASE_URL = "http://localhost:8080";

export async function apiPost(path, body) {
  const resp = await fetch(`${API_BASE_URL}${path}`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body),
  });

  let data;
  try {
    data = await resp.json();
  } catch {
    data = null;
  }

  if (!resp.ok) {
    const msg = data?.message || data || `Erro HTTP: ${resp.status}`;
    throw new Error(msg);
  }

  return data;
}
