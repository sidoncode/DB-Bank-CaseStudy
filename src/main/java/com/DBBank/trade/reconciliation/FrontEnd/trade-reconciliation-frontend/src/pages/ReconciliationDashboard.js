import React, { useState } from 'react';
import { startReconciliation, getDifferences } from '../api/reconciliationService';

const ReconciliationDashboard = () => {
  const [runId, setRunId] = useState(null);
  const [differences, setDifferences] = useState([]);

  const handleReconcile = () => {
    startReconciliation().then(res => {
      setRunId(res.data);
      return getDifferences(res.data);
    }).then(res => setDifferences(res.data))
      .catch(err => console.error('Reconciliation failed', err));
  };

  return (
    <div>
      <h2>Reconciliation</h2>
      <button onClick={handleReconcile}>Start Reconciliation</button>

      {runId && (
        <>
          <h3>Run ID: {runId}</h3>
          <table>
            <thead>
              <tr>
                <th>Trade ID</th>
                <th>Field</th>
                <th>System A</th>
                <th>System B</th>
              </tr>
            </thead>
            <tbody>
              {differences.map((diff) => (
                <tr key={diff.id}>
                  <td>{diff.tradeId}</td>
                  <td>{diff.fieldName}</td>
                  <td>{diff.valueSystemA}</td>
                  <td>{diff.valueSystemB}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      )}
    </div>
  );
};

export default ReconciliationDashboard;
