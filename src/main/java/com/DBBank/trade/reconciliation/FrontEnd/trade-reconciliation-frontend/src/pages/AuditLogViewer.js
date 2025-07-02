import React, { useEffect, useState } from 'react';
import { getAuditLogs, getErrorLogs } from '../api/auditService';

function AuditLogViewer() {
  const [logs, setLogs] = useState([]);
  const [errors, setErrors] = useState([]);

  useEffect(() => {
    getAuditLogs().then(res => setLogs(res.data));
    getErrorLogs().then(res => setErrors(res.data));
  }, []);

  return (
    <div className="container mt-4">
      <h3>Audit Logs</h3>
      <pre>{JSON.stringify(logs, null, 2)}</pre>

      <h3 className="mt-4">Error Logs</h3>
      <pre>{JSON.stringify(errors, null, 2)}</pre>
    </div>
  );
}

export default AuditLogViewer;
