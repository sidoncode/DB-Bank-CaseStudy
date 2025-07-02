import React, { useEffect, useState } from 'react';
import { getAllTrades, deleteTradeById } from '../api/tradeService';
import './TradeList.css';

const TradeList = () => {
  const [trades, setTrades] = useState([]);

  useEffect(() => {
    fetchTrades();
  }, []);

  const fetchTrades = () => {
    getAllTrades()
      .then(response => setTrades(response.data))
      .catch(error => console.error('Error fetching trades:', error));
  };

  const formatDate = (timestamp) => {
    if (!timestamp) return 'N/A';
    const date = new Date(timestamp);
    return date.toLocaleDateString();
  };

  const handleDelete = (id) => {
    if (window.confirm('Are you sure you want to delete this trade?')) {
      deleteTradeById(id)
        .then(() => {
          setTrades(prev => prev.filter(trade => trade.id !== id));
        })
        .catch(err => console.error('Delete failed:', err));
    }
  };

  return (
    <div className="trade-list-container">
      <h2>All Trades</h2>
      <table className="trade-table">
        <thead>
          <tr>
            <th>Trade ID</th>
            <th>Instrument</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Source</th>
            <th>Trade Date</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {trades.length > 0 ? (
            trades.map((trade) => (
              <tr key={trade.id}>
                <td>{trade.tradeId}</td>
                <td>{trade.instrument}</td>
                <td>{trade.quantity}</td>
                <td>{trade.price}</td>
                <td>{trade.sourceSystem}</td>
                <td>{formatDate(trade.tradeDate)}</td>
                <td>
                  <button className="delete-btn" onClick={() => handleDelete(trade.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="7">No trades found.</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default TradeList;
