import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import axios from "axios";
function RiskList() {
  const [risks, setRisks] = useState([]);

  useEffect(() => {
    axios
      .get("/api/risks")
      .then((response) => {
        setRisks(response.data);
      })
      .catch((error) => {
        console.error("Error fetching risks:", error);
      });
  }, []);

  return (
    <div>
      <h1>Risks</h1>
      <ul>
        {risks.map((risk) => (
          <li key={risk.id}>
            {risk.description} - {risk.severity}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default RiskList;
