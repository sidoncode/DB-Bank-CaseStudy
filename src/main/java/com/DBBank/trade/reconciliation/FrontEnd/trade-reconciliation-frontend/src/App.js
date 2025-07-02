import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import TradeList from './pages/TradeList';
import InstrumentList from './pages/InstrumentList';
import ReconciliationDashboard from './pages/ReconciliationDashboard';
import AuditLogViewer from './pages/AuditLogViewer';
import DifferencesReport from './pages/DifferencesReport';
import './App.css'; // Add custom styles here

function App() {
  return (
    <Router>
      <Navbar />
      <div className="app-content">
        <Routes>
          <Route path="/" element={<TradeList />} />
          <Route path="/trades" element={<TradeList />} />
          <Route path="/instruments" element={<InstrumentList />} />
          <Route path="/reconciliation" element={<ReconciliationDashboard />} />
          <Route path="/reconciliation/differences" element={<DifferencesReport />} />
          <Route path="/audit" element={<AuditLogViewer />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
