import axios from 'axios';

const API = 'http://localhost:9090/api/instruments';

export const getAllInstruments = () => axios.get(API);
export const getInstrumentBySymbol = symbol => axios.get(`${API}/${symbol}`);
export const reloadInstrumentCache = () => axios.post(`${API}/cache/reload`);
export const createInstrument = data => axios.post(API, data);
export const deleteInstrument = symbol => axios.delete(`${API}/${symbol}`);
