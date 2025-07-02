import React, { useEffect, useState } from 'react';
import { getDifferences } from '../api/reconciliationService';

const DifferencesReport = () => {
  const [differences, setDifferences] = useState([]);

  useEffect(() => {
    getDifferences()
      .then(res => setDifferences(res.data))
      .catch(err => console.error('Error fetching differences:', err));
  }, []);

  return (
    <div>
      <h2>Reconciliation Differences</h2>
      {differences.length === 0 ? (
        <p>No differences found. 🎉</p>
      ) : (
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
            {differences.map((diff, index) => (
              <tr key={index}>
                <td>{diff.tradeId}</td>
                <td>{diff.fieldName}</td>
                <td>{diff.valueSystemA}</td>
                <td>{diff.valueSystemB}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default DifferencesReport;
