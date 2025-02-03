import './App.css'
import {Link} from "react-router";
import {useEffect} from "react";
import {Env} from "./Env.ts";
import { useState } from 'react';

function App() {

  const [poem, setPoem] = useState('');
  const [analysis, setAnalysis] = useState('');

  useEffect(() => {
    fetch(`${Env.API_BASE_URL}/ping`)
      .then(response => response.text())
      .then(body => console.log(body));
  }, []);

  const handleSubmit = () => {
    // Placeholder for actual analysis logic
    setAnalysis('Lorem ipsum dolor sit amet, consectetur adipiscing elit.');
  };

  return (
    <>
      <h1>Poetik</h1>
        <div>
        <textarea
          value={poem}
          onChange={(e) => setPoem(e.target.value)}
          placeholder="Enter your poem here..."
          rows={10}
          cols={50}
        />
        <br />
        <button onClick={handleSubmit} className="bg-red-500 text-black px-4 py-2 rounded">Submit</button>
        <br />
        <textarea
          value={analysis}
          readOnly
          placeholder="Analysis will appear here..."
          rows={4}
          cols={50}
        />
      </div>
      <Link to='/cake'>Visit /cake</Link>
    </>
  )
}

export default App;
