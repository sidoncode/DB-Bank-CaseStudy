import React, { useEffect, useState } from 'react';
import { getAllInstruments, deleteInstrument } from '../api/instrumentService';
import './InstrumentList.css'; // Optional CSS styling

const InstrumentList = () => {
  const [instruments, setInstruments] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [deletingId, setDeletingId] = useState(null);

  useEffect(() => {
    fetchInstruments();
  }, []);

  const fetchInstruments = () => {
    setLoading(true);
    setError(null);
    getAllInstruments()
      .then((response) => setInstruments(response.data))
      .catch(() => setError('Error fetching instruments.'))
      .finally(() => setLoading(false));
  };

  const handleDelete = (id) => {
    if (window.confirm('Delete this instrument?')) {
      setDeletingId(id);
      deleteInstrument(id)
        .then(() => setInstruments(prev => prev.filter(i => i.id !== id)))
        .catch(() => alert('Delete failed.'))
        .finally(() => setDeletingId(null));
    }
  };

  return (
    <div className="instrument-list-container">
      <h2>All Instruments</h2>
      <table className="instrument-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Symbol</th>
            <th>Name</th>
            <th>ISIN</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {loading ? (
            <tr><td colSpan="5">Loading instruments...</td></tr>
          ) : error ? (
            <tr><td colSpan="5" style={{ color: 'red' }}>{error}</td></tr>
          ) : instruments.length === 0 ? (
            <tr><td colSpan="5">No instruments found.</td></tr>
          ) : (
            instruments.map((instrument) => (
              <tr key={instrument.id}>
                <td>{instrument.id}</td>
                <td>{instrument.symbol}</td>
                <td>{instrument.name}</td>
                <td>{instrument.isin}</td>
                <td>
                  <button
                    className="delete-btn"
                    onClick={() => handleDelete(instrument.id)}
                    disabled={deletingId === instrument.id}
                  >
                    {deletingId === instrument.id ? 'Deleting...' : 'Delete'}
                  </button>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
};

export default InstrumentList;
