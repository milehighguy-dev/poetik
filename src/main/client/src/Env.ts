// Env.ts

const {VITE_API_BASE_URL, ...otherViteConfig} = import.meta.env;

export const Env = {
    API_BASE_URL: VITE_API_BASE_URL as string,
    __vite__: otherViteConfig,
};

// make it easy to figure out the frontend environment config at any moment
console.log(Env);