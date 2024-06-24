import React, { useState } from "react";
import axios from "axios";

const RiskForm = ({ onRiskAdded }) => {
  const [description, setDescription] = useState("");
  const [type, setType] = useState("");
  const [severity, setSeverity] = useState("");
  const [status, setStatus] = useState("");
  const [mitigationPlan, setMitigationPlan] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    const newRisk = { description, type, severity, status, mitigationPlan };

    axios
      .post("/api/risks", newRisk)
      .then((response) => {
        onRiskAdded(response.data);
      })
      .catch((error) => {
        console.error("Error adding risk:", error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Description:</label>
        <input
          type="text"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
      </div>
      <div>
        <label>Type:</label>
        <input
          type="text"
          value={type}
          onChange={(e) => setType(e.target.value)}
        />
      </div>
      <div>
        <label>Severity:</label>
        <input
          type="text"
          value={severity}
          onChange={(e) => setSeverity(e.target.value)}
        />
      </div>
      <div>
        <label>Status:</label>
        <input
          type="text"
          value={status}
          onChange={(e) => setStatus(e.target.value)}
        />
      </div>
      <div>
        <label>Mitigation Plan:</label>
        <input
          type="text"
          value={mitigationPlan}
          onChange={(e) => setMitigationPlan(e.target.value)}
        />
      </div>
      <button type="submit">Add Risk</button>
    </form>
  );
};

export default RiskForm;
