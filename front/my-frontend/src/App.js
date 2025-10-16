import './App.css';
import {useEffect, useState} from "react";
import axios from 'axios';

function App() {

  const [spaces, setSpaces] = useState([]);
  const [status, setStatus] = useState("loading");

  useEffect(() => {
    axios.get("/api/espaco/v1")
        .then((response) => {
          setSpaces(response.data);
        })
    .catch((error) => {
      console.error("there was an error fetching the data!", error);
      setStatus("Could not connect to the backend");
      setSpaces([]);
    });
  }, []);

  const renderSpaces = () => {
    if(spaces.length === 0){
      return<p>{status}</p>;
    }

    return (
        <ul>
          {spaces.map(space => (
              <li key={space.id}>
                <strong>{space.name || "unnamed space"}</strong>: {space.description || "No Description"}
              </li>
          ))}
        </ul>
    );
  };
  return (
      <div className="App">
        <header className="App-header">
          <h1>Spaces Management</h1>
          <h2>Data from Springboot</h2>
          <div className={"space-list"}>
            {renderSpaces()}
          </div>
        </header>
      </div>
  );
}

export default App;
