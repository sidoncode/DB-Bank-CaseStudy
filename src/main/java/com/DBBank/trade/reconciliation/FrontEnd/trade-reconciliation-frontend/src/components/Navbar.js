import { Link } from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-left">
        <Link to="/" className="navbar-logo">
          <img src="/dbb.jpeg" alt="Deutsche Bank" />
        </Link>
        <span className="navbar-title">Trade Reconciliation</span>
      </div>
      <div className="navbar-links">
        <Link to="/trades">Trades</Link>
        <Link to="/instruments">Instruments</Link>
        <Link to="/reconciliation">Reconciliation</Link>
        <Link to="/reconciliation/differences">Differences</Link>
      </div>
    </nav>
  );
};

export default Navbar;
