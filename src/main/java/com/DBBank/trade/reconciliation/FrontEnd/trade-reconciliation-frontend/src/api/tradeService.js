import axios from 'axios';

const API_URL = 'http://localhost:9090/api/trades';

export const getAllTrades = () => axios.get(API_URL);
export const getTradeById = id => axios.get(`${API_URL}/${id}`);
export const createTrade = data => axios.post(API_URL, data);
export const deleteTrade = id => axios.delete(`${API_URL}/${id}`);

export const deleteTradeById = (id) => axios.delete(`${API_URL}/${id}`);
