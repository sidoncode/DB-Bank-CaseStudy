import axios from 'axios';

const API = 'http://localhost:9090/api/reconciliation';

export const startReconciliation = () => axios.post(`${API}/start`);
export const getReconciliationStatus = id => axios.get(`${API}/status/${id}`);
export const getDifferences = () => axios.get(`${API}/differences`);
