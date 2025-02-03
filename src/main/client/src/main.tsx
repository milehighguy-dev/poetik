import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import {createBrowserRouter, RouterProvider} from 'react-router';

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
  },
    {
      path: '/cake',
      element: <div style={{ fontSize: 150 }}>🍰</div>,
    },
],
 {
    basename: '/dashboard',
  }
);

createRoot(document.getElementById('root')!).render(
  <StrictMode>
   <RouterProvider router={router} />
  </StrictMode>,
)
