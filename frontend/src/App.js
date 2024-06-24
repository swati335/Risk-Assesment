import React, { useState } from "react";
import RiskList from "./components/RiskList";
import RiskForm from "./components/RiskForm";

const App = () => {
  const [risks, setRisks] = useState([]);

  const handleRiskAdded = (newRisk) => {
    setRisks([...risks, newRisk]);
  };

  return (
    <div className="container">
      <h1>Enterprise Risk Management</h1>
      <RiskForm onRiskAdded={handleRiskAdded} />
      <RiskList risks={risks} />
    </div>
  );
};

export default App;
